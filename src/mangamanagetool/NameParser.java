/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mangamanagetool;

import java.util.ArrayList;

/**
 *
 * @author junyang_huang 
 * @purpose: get a list of author names from managa files
 * 
 */
public class NameParser
{

    /**
     * input an author name string and return an array of author names
     * e.g  生徒会室 (あきもと大)  will return [生徒会室, あきもと大]
     * abgrund (さいかわゆさ) will return [abgrund,さいかわゆさ]
     * @param the author name
     * @return an array of author names
     */
    public static ArrayList<String> getAuthorNameEntry(String s)
    {
        String[] names = s.split("\\[|\\]|\\(|\\)|,");
        ArrayList<String> result = new ArrayList<String>(2);
        for (String tempS : names)
        {
            result.add(tempS.trim());
        }
        return result;
    }

    /**\
     * compare two strings and calculate their string distance
     * @param s1 
     * @param s2
     * @return the string distance
     */
    public static int stringDistance(String s1, String s2)
    {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++)
        {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++)
            {
                if (i == 0)
                {
                    costs[j] = j;
                }
                else
                {
                    if (j > 0)
                    {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                        {
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        }
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
            {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

    
    /**
     *return author name from a file name
     * e.g  (COMIC1☆7) [DUAL BEAT (柚木貴)] LONESOME DUMMY (ザ·キング·オブ·ファイターズ).zip  will give DUAL BEAT (柚木貴) 
     * (サンクリ60) [abgrund (さいかわゆさ)] やばいと思ったがちー欲を抑えきれなかった・・・! (はたらく魔王さま!).zip will give abgrund (さいかわゆさ)  
     * @param fn fileName
     * @return author name
     */
    public static String getAuthorName(String fn)
    {
        String result = null;
        boolean t1 = false, t2 = false;
        int index1 = 0, index2 = 0;
        //find "[" and "]"
        for (int ii = 0; ii < fn.length(); ii++)
        {
            if (fn.charAt(ii) == '[')
            {
                index1 = ii;
                t1 = true;
                for (int jj = ii + 1; jj < fn.length(); jj++)
                {
                    if (fn.charAt(jj) == ']')
                    {
                        index2 = jj;
                        t2 = true;
                        break;
                    }
                }
                break;
            }
        }

        //if contain "[]", the author name
        if (t2 && t1)
        {
            String temp = fn.substring(index1 + 1, index2);
            if (!containWrongWord(temp))
            {
                result = temp;
                return result.trim();
            }
        }
        return result;
    }
    //exclude non-author name 
    public static final String[] wrongWords =
    {
        "汉化", "漢化","English","Chinese","Korean","中文","한국",
        "アニメ", "anime", "Anime",
        "雑誌", "杂志", 
        "Anthology", "アンソロジー", 
        "Artist","アーティスト",
        "成年コミック", "コミック","一般コミック","COMIC",
        "Doujinshi", "Doujin", "同人", "同人", 
        "DL版",  
        "Artbook", "画集",
        "COMIC1☆", "サンクリ"
    };

    //exclude certain string
    private static boolean containWrongWord(String s)
    {
        //comiket (e.g c79, c82) is not an authour name
        //pure number is not an anthour e.g 101012
        if (s == null || (s.matches("[Cc][0-9]{2}|[0-9]+")))
        {
            return true;
        }

        //should not contain any wrong word
        for (String w : wrongWords)
        {
            if (s.contains(w))
            {
                return true;
            }
        }
        return false;
    }
    
    
    private static final String[] CompressionType =
    {
        "zip", "rar", "7zip", "pdf"
    };

    /*
     * decide if file is compressed file based on its extension
     */
    public static boolean isCompressionFile(String fileExtension)
    {
        for (String etx : CompressionType)
        {
            if (fileExtension.equalsIgnoreCase(etx))
            {
                return true;
            }
        }
        return false;
    }
}
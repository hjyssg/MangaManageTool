MangaManageTool
===============

A Java Toolkit that helps manage doujin manga file 

如果你是一名阿宅，你擁有超過超多的漫畫、同人誌。你一定會想整理他們。 
  
 
根據我個人實踐，最好的整理辦法就是按作者名分類。最好的整理辦法就是按作者名分類。這個很重要，這裡要說兩次。
因為實用的作者總是很使用，難用的作者一直都那麼難用。
並且一般漫畫文件都有標作者，分起來比較方便。

同人作品有人可以按題材分。但是同人作品一般水平差別很多，魚龍混雜。都放在一起會導致有時你想到一個本子，但找不到。
作者也有水平好壞，你可以實用的作者放一個文件夾，不實用的作者放一個文件夾。
 



###具體整理方法  

所有漫畫文件用壓縮文件保存，不要解壓成一個圖片文件夾。這樣利於複製傳輸。
比如，你有500本漫畫。A組是全部解壓的，B組是壓縮成zip。你嘗試從一個移動硬盤移動到另一個。B組會明顯快於A組。  
現在越來越多軟件支持無需解壓直接看壓縮文件內的圖片。比如，大陸的haoZip，ios上面的Bookman。
壓縮文件直接拿來看，實在不必去解壓，浪費硬盤空間。 
 
文件分到兩個文件夾，一個是整理好的，一個沒整理過的。
整理的文件夾是這樣的： 按一個一個作者創建文件，把對應的文件放進去。

    ......./_Manga/Sorted_By_Author$  ls - 1
    23.4ド (イチリ)      
    ドウガネブイブイ(あぶりだしざくろ)  
    3 colors cat (みけ田みい吉)    
    トーティシェル (きんく)  
    40010壱号 (40010試作型)   
    とりあえず(仮) (とろろ)  
    5年目の放課後  
    とりのおいしいところ (鳥三)  
    ActiveMover・迷-めいず-  
    にびなも凸面体(アイソトニクス)  
    Heaven's Gate (安藤智也)  
    メメ50  
    LEYMEI  
    三血中吐     
    (.............)




你可以按這樣手動整理。但這樣的做法的實際問題是：            
1.隨著文件數量增加，一個一個文件找相應作者文件夾很困難。     
2.當新作者出現的時候，憑記憶沒法及時創建該作者相對應的文件。     
3.非常非常費時費力。整理一次漫畫要30多個小時。     

所以我自己寫了一個java程序幫助這個工程整理。 
你打開選好沒整理的壓縮文件所在的文件夾。在選在已經整理好文件夾所在的根目錄。最後點執行。
這個程序會自動讀取兩個文件夾的所有文件的文件名，配對計算，最後在會/dist文件夾生成的shell command文件
告訴你要移動哪些文件，要新建哪些文件夾。你需自己用terminal去執行shell command或者根據此手動整理。

之所以不直接由這個程序執行移動和創建文件夾操作是因為：   
1.移動文件是一件很risky的事。丟失、損壞都有可能發生。  
2.這個程序的利用文件名來進行匹配，不是100%正確的，需要人工判斷。   
3.手動移動才有樂趣，程序一下跑完就沒意思了。    
4.就是我覺得作為軟件工程師，隨便動別人電腦內部文件是一件沒道德的事情。

如果你用的是Windows，我推薦你使用everything來幫助你移動文件。

###打開方式
1.在Mac下直接右點打開dist/jar文件。
2.用Netbeans打開來run。這是一個Netbeans Project。 

如果你有任何好的主意或者發現bug，請pull request或者fork給我來進行修改。

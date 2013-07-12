MangaManageTool
===============

A Java Toolkit that help manage doujin manga file 

如果你是一名阿宅，你擁有超過2000本以上的漫畫、同人誌。你一定會想整理他們。 
根據我個人實踐，最好的辦法就是按作者名分類。 
------------- 
具體而言就是按作者名一個一個創建文件夾，然後把那個作者的作品放進去。 

比如，我的整理的文件是這樣： 




你可以按這樣手動整理（我這樣做了4年）。 
但這樣的做法的實際問題是： 
1. 隨著文件數量增加，一個一個文件找相應作者文件夾很困難。 
2.當新作者出現的時候，沒有創建該作者相對應的文件。 
3.非常非常費時費力。我以前整理一次漫畫要30多個小時。 

所以我自己寫了一個java程序幫助這個工程整理。 
這個程序需要兩個argument。第一個是你存放整理好文件夾的所在地址，第二個是還沒整理好文件的所在地址。 

這個程序會自動讀取兩個文件夾的文件名，比較計算，然後告訴你要移動那些文件，以及你要新建那些文件夾。 
之後你需要手動移動文件。我可以增加代碼，來幫助移動文件。但移動文件存在風險（文件損壞丟失），並且這個程序進行的string比較不是 
100%正確的。更重要的時，手動移動才有樂趣，程序一下跑完就沒意思了。 

這個程序是一個netbeans project，下載後請用netbeans打開。 

這個程序的算法效率其實不是最好的。我完全可以用sql來提升，但整理漫畫一年可能就一兩次，所以我覺得無所謂。你可以pull request或者fork來進行修改。
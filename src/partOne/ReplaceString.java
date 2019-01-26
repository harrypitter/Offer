package partOne;

import java.util.ArrayList;

public class ReplaceString {
    private String replace(String oldString , String replaceString){
        char[] oldCharArray = oldString.toCharArray();
        char[] replaceCharArray = replaceString.toCharArray();

        int length = oldCharArray.length;
        int count = 0;

        //计算需要替换的空位数目
        for(int i=0;i<length;i++){
            if(oldCharArray[i]==' '){
                count++;
            }
        }

        //新数组长度
        int newLength = length+(3-1)*count;

        char[] newCharArray = new char[newLength];

        int oldPos = length-1;
        int newPos = newLength-1;
        //两个标识都从最后面开始向前面移动，直到到达最前方
        while(oldPos>=0&&newPos>=0){
            if(oldCharArray[oldPos]!=' ') //非空格的地方直接复制
            {
                newCharArray[newPos] = oldCharArray[oldPos];
                newPos--;
                oldPos--;
            }
            else{ //空格的地方采用替代方式复制
                newCharArray[newPos] = '0';
                newCharArray[newPos-1] = '2';
                newCharArray[newPos-2] ='%';
                newPos = newPos-3;
                oldPos--;
            }
        }

        String newString = String.valueOf(newCharArray);
        System.out.println("new String is:"+newString);
        return newString;
    }

    private String newReplace(String oldString,String ReplaceString){
        //创建存储各部分的ArrayList
        ArrayList<String> saveArrayList = new ArrayList<>();
        char[] oldCharArray = oldString.toCharArray();
        int length = oldCharArray.length;
        String tempString = "";

        //将原String分开存储入ArrayList
        for(int i=0;i<length;i++){
            if(oldCharArray[i]!=' '){
                tempString = tempString+String.valueOf(oldCharArray[i]);
                if(i==length-1){
                    saveArrayList.add(tempString);
                }
            }
            if(oldCharArray[i]==' '){
                if(tempString!=""){
                    saveArrayList.add(tempString);
                    tempString="";
                }
                saveArrayList.add(ReplaceString);
            }
        }

        String newString ="";
        for(String stringValue:saveArrayList){
            newString=newString+stringValue;
        }
        System.out.println("new String is:"+newString);
        return newString;


    }

    public static void main(String[] args) {
        String testString = "WE ARE HAPPY";
        String newString = new ReplaceString().replace(testString,"%20");

        new ReplaceString().newReplace(testString,"%21");


    }
}

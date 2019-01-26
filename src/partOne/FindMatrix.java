package partOne;

public class FindMatrix {
    private boolean find(int[][] matrix,int value){
        //矩阵长度不符合要求
        if(matrix==null||matrix.length<1||matrix[0].length<1){
            return false;
        }

        int height = matrix[0].length;
        int length = matrix.length;

        int startHeight = height-1;
        int startLenght = 0;
        //确保查找的数据在数组中
        //初始查找比对数值为矩阵右上角值
       while(startHeight>0&&startLenght<length){
           int getvalue = matrix[startLenght][startHeight];
           if(matrix[startLenght][startHeight]==value){
               System.out.println("查找的数值"+value+"是在第"+(startLenght+1)+"行，第"+(startHeight+1)+"列");
               return true;
           }
           //右端的数据大于要找的数据，往左移一列
           if(matrix[startLenght][startHeight]>value){
               startHeight--;
           }
           //右端的数据小于要找的数据，往下移一行
           if(matrix[startLenght][startHeight]<value){
               startLenght++;
           }
       }
        System.out.println("数组中不存在该数");
       return false;
    }

    public static void main(String[] args) {
        int[][] testMar={
                {1,2,3,5,5},
                {2,3,4,5,6},
                {2,5,6,7,8},
                {9,10,11,12,13}
        };
        boolean ter = new FindMatrix().find(testMar,4);


        boolean ter1 = new FindMatrix().find(testMar,17);



    }
}

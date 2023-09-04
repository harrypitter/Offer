package partOne;

public class FindBinaryTreeNode {

    private static class BinaryTreeNode{
        int data;
        BinaryTreeNode lefNode;
        BinaryTreeNode rightNode;
    }

    private static BinaryTreeNode construct(int[] preOrder,int[] minOrder){

        if(preOrder==null||minOrder==null||preOrder.length!=minOrder.length||preOrder.length<1){
            try {
                throw new Exception("输入的遍历数组有误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getRootNodeByPreFindAndMimFind(preOrder,0,preOrder.length-1,minOrder,0,minOrder.length-1);
    }

    /**
     * 先假定树中没有重复的值
     * @param preOrder 前序遍历拿到的数组
     * @param pStartPos   前序遍历开始的位置
     * @param pEndPos     前序遍历结束的位置
     * @param minOrder 中序遍历拿到的数组
     * @param mStartPos   中序遍历开始的位置
     * @param mEndPos     中序遍历结束的位置
     * @return BinaryTreeNode 返回根节点的值
     */
    private static BinaryTreeNode getRootNodeByPreFindAndMimFind(int[] preOrder,int pStartPos,int pEndPos,int[] minOrder,int mStartPos,int mEndPos){

        //开始位置大于结束位置，说明元素处理完毕
        if(pStartPos>pEndPos){
            return null;
        }

        BinaryTreeNode rootNode = new BinaryTreeNode();

        //前序遍历第一个是根节点数据
        rootNode.data = preOrder[pStartPos];

        //通过查找中序遍历中根节点位置，把数组分为两部分，一部分就是左子树，另一部分就是右子树
        int minRootIndex = -1;
        for(int i=mStartPos;i<mEndPos;i++){
            if(minOrder[i]==preOrder[pStartPos]){
                minRootIndex = i;
            }
        }

        if(minRootIndex==-1)//在中序遍历中没有找到根节点位置，那么说明遍历数组有问题
        {
            try {
                throw new Exception("遍历数组存在问题");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //中序遍历找到根节点位置在minRootIndex，那么中序遍历前minRootIndex-mStartPos个是左子树的中序遍历数组,最后一个的位置是在minRootIndex-1
        //所以对应的前序遍历中的从pStartPos+1到pStartPos+minRootIndex-mStartPo就是左子树的前序遍历数组（pStartPos是前序遍历中根节点所在位置）


        rootNode.lefNode = getRootNodeByPreFindAndMimFind(preOrder,pStartPos+1,pStartPos+minRootIndex-mStartPos,minOrder,mStartPos,minRootIndex-1);


        //中序遍历




        return null;
    }
}

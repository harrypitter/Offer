package partOne;

import java.util.Stack;

public class PrintLinkNode {
    private static class LinkNode{
        int data; //节点的数据
        LinkNode nextLinkNode; //下一个节点
    }

    //采用栈的方式实现
    private void printLinkNodeByStack(LinkNode linkNode)
    {
        if(linkNode==null){
            return;
        }

        Stack<LinkNode> stackList = new Stack<>();
        LinkNode pNode = linkNode;
        while (pNode!=null){
            stackList.push(pNode);
            pNode = pNode.nextLinkNode;
        }

        LinkNode temNode;
        while (!stackList.isEmpty()){
            temNode = stackList.pop();
            System.out.println("栈节点值是："+temNode.data);
        }

    }

    //采用递归的方式实现
    private void printLinkNodeByRecursion(LinkNode linkNode){
        if(linkNode!=null){
            if(linkNode.nextLinkNode!=null){
                printLinkNodeByRecursion(linkNode.nextLinkNode);
            }
        }
        System.out.println("递归节点值是："+linkNode.data);
    }

    public static void main(String[] args) {
        LinkNode rootNode = new LinkNode();
        rootNode.data=1;
        rootNode.nextLinkNode = new LinkNode();
        rootNode.nextLinkNode.nextLinkNode = new LinkNode();
        rootNode.nextLinkNode.nextLinkNode.nextLinkNode = new LinkNode();
        rootNode.nextLinkNode.nextLinkNode.nextLinkNode.nextLinkNode = new LinkNode();
        rootNode.nextLinkNode.data=2;
        rootNode.nextLinkNode.nextLinkNode.data=3;
        rootNode.nextLinkNode.nextLinkNode.nextLinkNode.data=4;
        rootNode.nextLinkNode.nextLinkNode.nextLinkNode.nextLinkNode.data=5;

        LinkNode pNode = rootNode;
        while (pNode!=null){
            System.out.println("原链表值："+pNode.data);
            pNode = pNode.nextLinkNode;
        }

        new PrintLinkNode().printLinkNodeByStack(rootNode);
        new PrintLinkNode().printLinkNodeByRecursion(rootNode);
    }

}

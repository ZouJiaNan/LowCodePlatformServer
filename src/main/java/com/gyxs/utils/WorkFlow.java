package com.gyxs.utils;

import com.gyxs.beans.Node;
import com.gyxs.beans.Functions;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WorkFlow {
    Map<Integer, Node> coNodes = new HashMap<>();
    //根节点
    Node root;

    public WorkFlow init(String data) {
        String[] ss = data.split(":");
        List<String> start_end_kvs = Arrays.asList(ss);
        start_end_kvs.removeIf(Objects::isNull);
        start_end_kvs.forEach((kv) -> {
            if (kv.isEmpty()) {
                return;
            }
            String[] s = kv.split("_");
            String[] startNodeInfo = s[0].split("-");
            String[] endNodeInfo = s[1].split("-");
            //获得起止节点信息
            Integer startNodeIndex = Integer.parseInt(startNodeInfo[0]);
            String startNodeName = startNodeInfo[1];
            Integer endNodeIndex = Integer.parseInt(endNodeInfo[0]);
            String endNodeName = endNodeInfo[1];
            //判断起止节点是否存在,不存在再创建,存在直接拿来用
            Node startNode;
            Node endNode;
            if (coNodes.get(startNodeIndex) == null) {
                startNode = new Node(startNodeIndex, startNodeName);
                startNode.setParam(Integer.parseInt(startNodeInfo[2]));
                coNodes.put(startNodeIndex, startNode);
            } else {
                startNode = coNodes.get(startNodeIndex);
            }
            if (coNodes.get(endNodeIndex) == null) {
                endNode = new Node(endNodeIndex, endNodeName);
                endNode.setParam(Integer.parseInt(endNodeInfo[2]));
                coNodes.put(endNodeIndex, endNode);
            } else {
                endNode = coNodes.get(endNodeIndex);
            }
            //组装功能
            assembleFunction(startNode);
            assembleFunction(endNode);
            //组装父子关系
            startNode.addChild(endNode);
            endNode.addParent(startNode);
            if ("开始".equals(startNode.getName())) {
                startNode.setFinish(true);
                root = startNode;
            }
        });
        return this;
    }

    /**
     * 给每个节点装配功能
     *
     * @param node
     */
    private void assembleFunction(Node node) {
        if (Functions.function_01.type.equals(node.getName())) {
            node.setFunction(Functions.function_01);
        }
        if (Functions.function_02.type.equals(node.getName())) {
            node.setFunction(Functions.function_02);
        }
    }

    /**
     * 递归遍历树
     *
     * @param node
     * @param doFunction
     */
    public void traversal(Node node, boolean doFunction) {
        int result = 0;
        //当前节点
        //当前节点不是根节点且父节点的数据已经传递过来，才能执行功能
        if (node != root && parentIsReady(node)) {
            result = doFunction ? doFunction(node) : -Integer.MAX_VALUE;
        }
        //子节点
        Set<Node> childs = node.getChilds();
        for (Node child : childs) {
            if (!node.isFinish()) {
                child.setParam(result);
            }
            traversal(child, doFunction);
        }
    }

    private boolean parentIsReady(Node node) {
        for (Node parent : node.getParents()) {
            if (!parent.isFinish()) {
                return false;
            }
        }
        return true;
    }

    private int doFunction(Node node) {
        System.out.println(node.getIndex() + node.getName());
        int param = node.getParam();
        int result;
        //如果parent只有一个，证明是开始节点的直接子节点
        if (node.getParents().size() == 2) {
            Integer[] array = new Integer[2];
            int i = 0;
            for (Node parent : node.getParents()) {
                array[i++] = parent.getParam();
            }
            result = node.getFunction().function.doFunction(array[0], array[1]);
            System.out.println("输入:" + array[0]+","+array[1]);
        } else {
            result = node.getFunction().function.doFunction(param, 0);
            System.out.println("输入:" + param);
        }
        System.out.println("输出:" + result);
        System.out.println("\n");
        node.setFinish(true);
        return result;
    }

    public WorkFlow input(int param) {
        this.root.setParam(param);
        return this;
    }

    public void start() {
        traversal(root, true);
    }
}

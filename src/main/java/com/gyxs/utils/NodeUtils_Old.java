package com.gyxs.utils;

import com.gyxs.beans.NodeOld;
import com.gyxs.beans.Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Deprecated
public class NodeUtils_Old {
    //节点集合
    private static List<NodeOld> nodeOldList =new ArrayList<>();
    //输出日志
    private static StringBuffer log;

    private static NodeOld[] nodeOlds;

//    public static NodeUtils init(String path) {
//        nodeList.clear();
//        String filePath = "D:\\template.txt";
//        File file = new File(filePath);
//        try {
//            String fileContent = new String(Files.readAllBytes(Paths.get(file.getPath())));
//            JSONObject jsonObject = JSON.parseObject(fileContent); 
//            JSONArray cells = jsonObject.getJSONArray("cells");
//            //遍历每一个节点
//            Node node=null;
//            for (Object cell : cells) {
//                String[] attrs=cell.toString().split(",");
//                Integer index=-1;
//                String name="";
//                //遍历节点中的每一个属性
//                for (String attr:attrs){
//                    if(attr.startsWith("\"zIndex\"")||attr.startsWith("\"attrs\"")) {
//                        //获取节点的位序
//                        if (attr.startsWith("\"zIndex\"")) {
//                            String indexStr = attr.replaceAll("}", "").split(":")[1];
//                            index = Integer.parseInt(indexStr);
//                        }
//                        //获取节点的名称
//                        if (attr.startsWith("\"attrs\"")) {
//                            if(attr.split(":")[1].startsWith("{\"text\"")) {
//                                String[] s1 = attr.replaceAll("}", "").split(":");
//                                name = s1[s1.length - 1].replaceAll("\"", "").replaceAll("\"", "");
//                            }
//                        }
//                        //判断是不是处理节点，是的话将其放入map
//                        if(index!=-1&&!"".equals(name)) {
//                            nodeList.add(initNode(index,name));
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            sortNodes();
//        }
//        return new NodeUtils();
//    }

    public static NodeUtils_Old init(String data){
        nodeOldList.clear();
        String[] kvs=data.split("_");
        for(String kv:kvs){
            if("".equals(kv)||kv==null){
                continue;
            }
            String[] kvArray=kv.split("-");
            nodeOldList.add(initNode(Integer.parseInt(kvArray[0]),kvArray[1]));
        }
        //去空
        nodeOldList.removeIf(Objects::isNull);
        sortNodes();
        return new NodeUtils_Old();
    }

    //初始化每个节点
    private static NodeOld initNode(int index, String name){
        if(Functions.function_01.type.equals(name)){
            return new NodeOld(index,name, Functions.function_01);
        }
        if(Functions.function_02.type.equals(name)){
            return new NodeOld(index,name, Functions.function_02);
        }
        return null;
    }

    private static NodeOld[] sortNodes(){
        nodeOlds =new NodeOld[nodeOldList.size()];
        Arrays.sort(nodeOldList.<NodeOld>toArray(nodeOlds));
        return nodeOlds;
    }

    public static String runWorkFlow(String data){
        init(data);
        log=new StringBuffer();
        //输入
//        int a=1;
//        int b=3;
//        for (NodeOld nodeOld : nodeOlds) {
//            //日志
//            log.append(LogUtils.info("输入1："+a+"\t"+"输入2："+b)+"\n");
//            a= nodeOld.getFunction().function.doFunction(a,b);
//        }
        return log.toString();
    }

}

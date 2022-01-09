package com.basic.common;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/4 11:22
 */
public interface CoordinatesProcessing {

    //检查坐标合法性
    public  boolean checkCoordinatesValidity(int[] coordinates);

    //分析坐标
    default int[] getCoordinatesFrom(String coordinates){
        if(coordinates != null){
            String[] tmp = coordinates.trim().split(",");
            int[] res;

            if(tmp.length == 3){
                try{
                    res = new int[]{Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])};
                }catch(NumberFormatException nfe){
                    return new int[]{-1, -1, -1};
                }
                return res;
            }
        }
        return new int[]{-1, -1, -1};
    }

    default int[] getCoordinatesFrom(int[] coordinates){
        if(coordinates != null){
            if(coordinates.length == 3)
                return coordinates;
        }
        return new int[]{-1, -1, -1};

    }
}

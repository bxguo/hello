package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bxguo on 2018/5/9 23:55
 */
public class ListEdit {
    public static void main(String[] args) {

        List<Integer> listDB = new ArrayList();
        List<Integer> listWeb = new ArrayList();

        Boolean isExist = false;
        List delList = new ArrayList();
        //先删除
        for (Integer db : listDB) {
            for (Integer web : listWeb) {
                isExist = false;
                if (db == web){
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                delList.add(db);
            }
        }

        //新增
        for (Integer web : listWeb) {
            isExist = false;
            for (Integer db : listDB) {
                if (web == db){

                }
            }
        }
    }
}

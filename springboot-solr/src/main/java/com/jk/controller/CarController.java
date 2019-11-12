package com.jk.controller;

import com.jk.model.Car;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.*;

@Controller
@RequestMapping("solr")
public class CarController {

    @Autowired
    private SolrClient client;

    @RequestMapping("toseach")
    public String query(){
        return "index";
    }
    @RequestMapping("search")
    @ResponseBody
    public Map<String, Object> search(Car car, Integer page, Integer rows){

        Map<String, Object> map1=new HashMap<>();

        try {
            SolrQuery params = new SolrQuery();

            //查询条件, 这里的 q 对应 下面图片标红的地方
            if (car.getCarname()!=null && !"".equals(car.getCarname())){
                params.set("q",car.getCarname());
            }else{
                params.set("q","*:*");
            }


            //过滤条件
           // params.set("fq", "product_price:[100 TO 100000]");

            //排序
            params.addSort("carsl", SolrQuery.ORDER.desc);

            //分页
            if (page==null){
                params.setStart(0);
            }else{
                params.setStart((page-1)*rows);
            }
            if(rows==null){
                params.setRows(5);
            }else{
                params.setRows(rows);
            }

            //默认域
            params.set("df", "carname");

            //只查询指定域
            //params.set("fl", "id,product_title,product_price");

            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("carname");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");

            QueryResponse queryResponse = client.query(params);

            SolrDocumentList results = queryResponse.getResults();

            long numFound = results.getNumFound();

           // System.out.println(numFound);

            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();


            List<Car> list1=new ArrayList<>();
            for (SolrDocument result : results) {
                Car car1=new Car();
                String highFile="";


                //System.out.println(result.get("id"));
                /*System.out.println(result.get("product_title"));
                //System.out.println(result.get("product_num"));
                System.out.println(result.get("product_price"));
                //System.out.println(result.get("product_image"));*/

                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("carname");
                if (list==null){
                    highFile = result.get("carname").toString();
                }else{
                    highFile=list.get(0);
                }
                car1.setCarid(Integer.parseInt(result.get("id").toString()));
                car1.setCartime(result.get("cartime").toString());
                car1.setCarname(highFile);
                car1.setCarlx((Integer) result.get("carlx"));
                car1.setCarsl((Integer) result.get("carsl"));
                /*System.out.println(list.get(0));

                System.out.println("------------------");
                System.out.println();*/
                list1.add(car1);
            }
            map1.put("total",numFound);
            map1.put("rows",list1);
            return map1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @RequestMapping("delete")
    public String delete(String id)  {
        System.out.println("进来了");

        try {
            client.deleteById("core1",id);
            client.commit("core1");
            /*System.out.println("id");*/

            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "error";
    }

}


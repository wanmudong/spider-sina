package io.github.wanmudong.spidersina.spider.demo2.gecco;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 10:36
 * @description：
 * @modified By：
 * @version: $
 */
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.pipeline.Pipeline;
import io.github.wanmudong.spidersina.spider.demo.gecco.RegrexUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@PipelineName("productDetailPipeline")
public class ProductDetailPipeline  implements Pipeline<ProductDetail> {
    @Override
    public void process(ProductDetail productDetail) {
        System.out.println("~~~~~~~~~productDetailPipeline~~~~~~~~~~~");
        File resultFile = new File("result.txt");
        if (!resultFile.exists()) {
            try {
                resultFile.createNewFile();
            } catch (IOException e) {
                System.out.println("create result file failed: " + e);
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("result.txt", true);
        } catch (IOException e) {
            System.out.println("IOException");
        }

        try {
            fileWriter.write(RegrexUtil.match(productDetail.getContent()));
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("fileWriter.write failed: " + e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("fileWriter.close failed");
            }
        }
    }
}
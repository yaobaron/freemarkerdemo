package com.cobra.freemarker.service.impl;

import com.cobra.freemarker.service.StaticService;
import com.cobra.freemarker.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/3/24 2:07
 */
@Service
public class StaticServiceImpl implements StaticService {

    @Autowired
    private UserService userService;

    @Autowired
    private Configuration configuration;

    /**
     * 生成首页静态页面
     */
    @Override
    public void createIndexHtml() {
        try {
            /**获取输出目标文件输出流------开始*/
            String filepath = this.getClass().getResource("/").toURI().getPath()+"static/";
            File folder = new File(filepath);
            //如果文件夹不存在
            if (!folder.exists()) {
                folder.mkdir();
            }
            String indexFileName = "index.html";
            File indexHtml = new File(folder, indexFileName);
            //如果html文件不存在
            if (!indexHtml.exists()) {
                indexHtml.createNewFile();
            }
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexHtml),"UTF-8"));
            /**获取输出目标文件输出流------结束*/

            //获取数据
            Map<String, Object> map = new HashMap<>();
            map.put("users", userService.findAllUsers());

            //获取模板
            Template template = configuration.getTemplate("list.ftl");

            //把数据和输出文件信息交给模板得到静态html文件
            template.process(map,out);

            out.flush();
            out.close();}
        catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

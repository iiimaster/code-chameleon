import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author GENIUS
 * @version 1.0.0
 * @ClassName FreeMarkerTest.java
 * @Description TODO  FreeMarker 模板引擎 使用
 * @createTime 2024年07月07日 16:18:00
 */
public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        // 1、 创建全局模板引擎对象

        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(freemarker.template.Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        // 解决 FreeMarker 打印奇怪的数字格式 (比如 1,000,000 或 1 000 000 而不是 1000000)
        // http://freemarker.foofun.cn/app_faq.html#faq_number_grouping -> FAQ 3
        configuration.setNumberFormat("0.######");

        // 2、创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        // 3、创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "杨花");
        dataModel.put("currentYear", 2024);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://baidu.com");
        menuItem1.put("label", "寻花问柳");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://bilibili.com");
        menuItem2.put("label", "水性杨花");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);

        // 4、生成
        Writer out = new FileWriter("myweb.html");
        template.process(dataModel, out);

        // 5、生成文件后别忘了关闭哦
        out.close();

    }
}

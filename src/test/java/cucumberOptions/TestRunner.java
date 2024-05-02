package cucumberOptions;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Đường dẫn tới file Feature
        features = "src/test/java/features",

        //Tìm đến package Step def
        glue = "stepDefinitions",

        //Step chưa dc implement sẽ k chạy chương trình từ đầu luôn
        //dryRun = true,

        //hiển thị output dễ đọc hơn
        monochrome = true,

        //show ra định dạng report: html/ json... cho mục đích show report trên jenkin chẳng hạn
        plugin = {"pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber.json"},

        //genner code hiển thị theo dạng CAMELCASE
        snippets = CucumberOptions.SnippetType.CAMELCASE,

        //có thể chạy theo tagName của scenario hoặc feature đều được
        tags = "@new_customer"
)
public class TestRunner {
}

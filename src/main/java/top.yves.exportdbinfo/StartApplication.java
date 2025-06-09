package top.yves.exportdbinfo;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * @author HeBo
 * @date 2025/6/9
 * @description
 */
public class StartApplication {
    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl(System.getProperty("jdbc.url"));
        hikariConfig.setUsername(System.getProperty("jdbc.username"));
        hikariConfig.setPassword(System.getProperty("jdbc.password"));
        //设置可以获取tables remarks信息
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
        hikariConfig.setMaximumPoolSize(2);
        DataSource dataSource = new HikariDataSource(hikariConfig);

        // 生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径，自己mac本地的地址，这里需要自己更换下路径
                .fileOutputDir("./")
                // 打开目录
                .openOutputDir(true)
                // 文件类型
                .fileType(EngineFileType.WORD)
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker).build();

        // 生成文档配置（包含以下自定义版本号、描述等配置连接）
        Configuration config = Configuration.builder()
                .version("1.0.0")
                .description("LTA系统数据库文档")
                .dataSource(dataSource)
                .engineConfig(engineConfig)
                .build();

        // 执行生成
        new DocumentationExecute(config).execute();
    }
}

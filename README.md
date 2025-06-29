启动指令
mvn clean package

java "-Djdbc.url=jdbc:mysql://localhost:3306/lta-database?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false" \
    "-Djdbc.username=root" "-Djdbc.password=root" -jar target/ExportDBInfo-1.0-SNAPSHOT.jar


-Djdbc.url=xxx -Djdbc.username=xxx -Djdbc.password=xxx
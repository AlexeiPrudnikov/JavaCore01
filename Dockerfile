FROM bellsoft/liberica-openjdk-alpine:latest
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out ./src/ru/geekbrains/homework01/exec/Main.java
CMD java -classpath ./out ru.geekbrains.homework01.exec.Main

package jungsuk.generics_enum_annotation.example;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111") // 유효하지 않은 애너테이션은 무시
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd="230225",hhmmss = "235959"), testTools = {"JUNIT1" , "junit2"})
public class AnnotationEx_3 {
    public static void main(String[] args) {
        Class<AnnotationEx_3> cls = AnnotationEx_3.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println(anno.testedBy());
        System.out.println(anno.testDate().yymmdd());
        System.out.println(anno.testDate().hhmmss());

        System.out.println();
        for(String str : anno.testTools()) {
            System.out.println(str);
        }

        for(Annotation a : cls.getAnnotations()) {
            System.out.println(a.toString());
        }


    }
}

@Retention(RetentionPolicy.RUNTIME) // 실행시에 가능하도록 지정
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType()  default TestType.FIRST;
    DateTime testDate();

}

enum TestType {
    FIRST, SECOND;
}

@Retention(RetentionPolicy.RUNTIME)  // 실행 시에 사용가능하도록 지정
@interface DateTime {
    String yymmdd();
    String hhmmss();
}
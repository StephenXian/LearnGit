import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class BadCase {

    public static class Resume implements Comparable {
        public Integer Resumefenshu;  // 简历分数，代表该简历对于这个企业总共评分多少

        public Integer age;         // 年龄

        @Override
        public int compareTo(Object o) {
            return this.Resumefenshu - ((Resume) o).Resumefenshu;
        }
    }

    // 选择合格的简历
    public List<Resume> xuanzeGoodResume(List<Resume> resumes) {
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).Resumefenshu <= 200) {
                resumes.remove(i);
            }

            if (resumes.get(i).age == Integer.valueOf(190)) {
                // 190岁这种错误数据的不要
                resumes.remove(i);
            }

            // 判断年龄不合适的去掉
            changeResumeByAge(resumes.get(i), true);

            // 根据简历评分排序,从大到小，优先选取简历评分高的
            Collections.sort(resumes);

        }

        return resumes;
    }

    // 判断年龄小于18岁的，需要换一份简历，丢弃掉当前的简历
    public Resume changeResumeByAge(Resume resume, boolean needChange) {
        if (resume == null || resume.age >= 18) {
            return resume;
        }

        if (resume.age < 18) {
            // 小于18岁的不要，换一个
            if (needChange || resume == null) {
                resume = new Resume();
                resume.age = 18;
            }
        }

        return resume;
    }

    public static void main(String[] args) {
        // 题目设定：这里有一个resumes 已经的初始化过程简化
        List<Resume> resumes = new ArrayList();
        Resume resume1 = new Resume();
        resume1.Resumefenshu = 200;
        resume1.age = 20;
        resumes.add(resume1);

        Resume resume2 = new Resume();
        resume2.Resumefenshu = 300;
        resume2.age = 17;
        resumes.add(resume2);

        Resume resume3 = new Resume();
        resume3.Resumefenshu = 199;
        resume3.age = 17;
        resumes.add(resume3);

        BadCase badCase = new BadCase();
        badCase.xuanzeGoodResume(resumes);

        //System.out.println(JsonUtils.getJsonString(resumes));
    }

}
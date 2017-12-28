package cn.edu.nju.service;

import javax.servlet.ServletOutputStream;

public interface StudentScoreService {
	
	/**
	 * 根据学号获得学生成绩
	 * @param id 学生学号
	 * @return 处理好的包含学生成绩信息的SOAP消息
	 */
	void getStudentScoreById(String id, ServletOutputStream out);
	void modifyStudentScore();
}

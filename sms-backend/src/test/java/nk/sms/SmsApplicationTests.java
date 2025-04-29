package nk.sms;

import nk.sms.service.AdminService;
import nk.sms.service.ObjectRetrieverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmsApplicationTests {
//	@Autowired
//	AdminService adminService;
	@Autowired
	ObjectRetrieverService objectRetrieverService;
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void testAdminService(){
//		adminService.getAllTeachers();
//		adminService.getAllStudents();
//
//	}
	@Test
	void testORServ(){
		objectRetrieverService.getStudentEntity(1);
		System.out.println(objectRetrieverService.getTeacherEntity(1));


	}
}

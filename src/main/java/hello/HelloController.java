package hello;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class HelloController {
	Question question = new Question();
	@GetMapping("/")
	public List index() {
		//return "Greetings from Spring Boot!";
		//Question question = new Question();
		return question.getAllQuestions();
	}
	@PostMapping("/")
	public void addQuestion(@RequestParam String text) {

		question.addQuestion(text);
	}

	@GetMapping("random")
	public String random() {
		//Question question = new Question();
		Random random = new Random();
		return question.getQuestion(random.nextInt(question.getSize()));
	}
}

package pet.project.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pet.project.calendar.entity.*;
import pet.project.calendar.repository.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CalendarApplication {

	private static final Logger log = LoggerFactory.getLogger(CalendarApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}
	@Bean
	public CommandLineRunner test(UserRepository userRepository,
								  WorkspaceRepository workspaceRepository,
								  EventRepository eventRepository,
								  NoteRepository noteRepository){
		return args -> {
			//TODO Test delete method for all Repos
//-------------------------------------Users-------------------
//			Optional<User> us1 = userRepository.findUserById(5);
//			us1.ifPresent(value -> log.info(value.toString()));
//
//			Iterable<User> us2 = userRepository.findAll();
//			List<User> us2res = (List<User>) us2;
//			log.info(us2res.toString());
//
//			Iterable<User> us3 = userRepository.findUsersByName("Danil");
//			List<User> us3res = (List<User>) us3;
//			log.info(us3res.toString());

//---------------------------------Credentials------------------

//			Optional<Credential> cred1 = credentialRepository.findCredentialsById(2);
//			cred1.ifPresent(value -> log.info(value.toString()));
//
//			Optional<Credential> cred2 = credentialRepository.findCredentialsByEmail("arteic4@yandex.ru");
//			cred2.ifPresent(value -> log.info(value.toString()));
//
//			Optional<Credential> cred3 = credentialRepository.findCredentialsByUserId(5);
//			cred3.ifPresent(value -> log.info(value.toString()));
//
//			Iterable<Credential> cred4 = credentialRepository.findAll();
//			List<Credential> cred4res = (List<Credential>) cred4;
//			log.info(cred4res.toString());


//-------------------------------------Workspaces------------
//			Optional<Workspace> work1 = workspaceRepository.findWorkspaceById(3);
//			work1.ifPresent(value -> log.info(value.toString()));
//
//			Iterable<Workspace> work2 = workspaceRepository.findWorkspacesByName("Study");
//			List<Workspace> work2res = (List<Workspace>) work2;
//			log.info(work2res.toString());
//
//			Iterable<Workspace> work3 = workspaceRepository.findWorkspacesByUserId(7);
//			List<Workspace> work3res = (List<Workspace>) work3;
//			log.info(work3res.toString());

//------------------------------------Events---------------------------------
//			Optional<Event> ev1 = eventRepository.findEventById(1);
//			ev1.ifPresent(value -> log.info(value.toString()));
//
//			Iterable<Event> ev2 = eventRepository.findEventsByTitle("JavaTasks");
//			List<Event> ev2res = (List<Event>) ev2;
//			log.info(ev2res.toString());
//
//			Iterable<Event> ev3 = eventRepository.findEventsByWorkspacesId(3);
//			List<Event> ev3res = (List<Event>) ev3;
//			log.info(ev3res.toString());

//--------------------------------------Notes------------------------------
//			Optional<Note> note1 = noteRepository.findNoteById(1);
//			note1.ifPresent(value -> log.info(value.toString()));
//
//			Iterable<Note> note2 = noteRepository.findNotesByDescription("lab1");
//			List<Note> note2res = (List<Note>) note2;
//			log.info(note2res.toString());
//
//			Iterable<Note> note3 = noteRepository.findNotesByEventId(3);
//			List<Note> note3res = (List<Note>) note3;
//			log.info(note3res.toString());
		};

	}

}

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
	public CommandLineRunner test(UsersRepository userRepository,
								  CredentialsRepository credentialsRepository,
								  WorkspacesRepository workspacesRepository,
								  EventsRepository eventsRepository,
								  NotesRepository notesRepository){
		return args -> {
			//TODO Test delete method for all Repos
//-------------------------------------Users-------------------
//			Optional<Users> us1 = userRepository.findUsersById(5);
//			us1.ifPresent(value -> log.info(value.toString()));
//
//			Iterable<Users> us2 = userRepository.findAll();
//			List<Users> us2res = (List<Users>) us2;
//			log.info(us2res.toString());
//
//			Iterable<Users> us3 = userRepository.findUsersByName("Danil");
//			List<Users> us3res = (List<Users>) us3;
//			log.info(us3res.toString());

//---------------------------------Credentials------------------

//			Optional<Credentials> cred1 = credentialsRepository.findCredentialsById(2);
//			cred1.ifPresent(value -> log.info(value.toString()));

//			Optional<Credentials> cred2 = credentialsRepository.findCredentialsByEmail("arteic4@yandex.ru");
//			cred2.ifPresent(value -> log.info(value.toString()));

//			Optional<Credentials> cred3 = credentialsRepository.findCredentialsByUserId(5);
//			cred3.ifPresent(value -> log.info(value.toString()));

//			Iterable<Credentials> cred4 = credentialsRepository.findAll();
//			List<Credentials> cred4res = (List<Credentials>) cred4;
//			log.info(cred4res.toString());


//-------------------------------------Workspaces------------
//			Optional<Workspaces> work1 = workspacesRepository.findWorkspacesById(3);
//			work1.ifPresent(value -> log.info(value.toString()));

//			Iterable<Workspaces> work2 = workspacesRepository.findWorkspacesByName("Study");
//			List<Workspaces> work2res = (List<Workspaces>) work2;
//			log.info(work2res.toString());

//			Iterable<Workspaces> work3 = workspacesRepository.findWorkspacesByUserId(7);
//			List<Workspaces> work3res = (List<Workspaces>) work3;
//			log.info(work3res.toString());

//------------------------------------Events---------------------------------
//			Optional<Events> ev1 = eventsRepository.findEventsById(1);
//			ev1.ifPresent(value -> log.info(value.toString()));

//			Iterable<Events> ev2 = eventsRepository.findEventsByTitle("JavaTasks");
//			List<Events> ev2res = (List<Events>) ev2;
//			log.info(ev2res.toString());

//			Iterable<Events> ev3 = eventsRepository.findEventsByWorkspacesId(3);
//			List<Events> ev3res = (List<Events>) ev3;
//			log.info(ev3res.toString());

//--------------------------------------Notes------------------------------
//			Optional<Notes> note1 = notesRepository.findNotesById(1);
//			note1.ifPresent(value -> log.info(value.toString()));

//			Iterable<Notes> note2 = notesRepository.findNotesByDescription("lab1");
//			List<Notes> note2res = (List<Notes>) note2;
//			log.info(note2res.toString());

//			Iterable<Notes> note3 = notesRepository.findNotesByEventId(3);
//			List<Notes> note3res = (List<Notes>) note3;
//			log.info(note3res.toString());
		};

	}

}

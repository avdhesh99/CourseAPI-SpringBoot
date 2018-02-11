package com.rnd.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;


public class TopicService {

	private static final Logger	logger	= Logger.getLogger(TopicService.class);
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "core java", "core java Description"), 
			new Topic("javascript", "javascript framework", "javascript framework Description")));
	

	public List<Topic> getAllTopic() {
		logger.info("TopicService:getAllTopic");
		return topics;
	}

	public Topic getTopic(String id) {
		logger.info("TopicService: getTopic");
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst()
				.get();
	}

	public void addTopic(Topic topic) {
		logger.info("TopicService: addTopic");
		topics.add(topic);

	}

	public void updateTopic(String id, Topic topic) {
		logger.info("TopicService: updateTopic--->start");

		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);

			if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
			}
		}
		logger.info("TopicService: updateTopic--->end");

	}

	public void deleteTopic(String id) {
		logger.info("TopicService: deleteTopic");
		
		topics.removeIf(t -> t.getId().equals(id));
	}

}

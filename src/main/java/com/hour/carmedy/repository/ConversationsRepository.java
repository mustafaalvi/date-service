package com.hour.carmedy.repository;

import com.hour.carmedy.model.Conversation;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface ConversationsRepository extends CrudRepository<Conversation, ObjectId> {
}

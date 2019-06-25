package app.service;

import app.domain.Message;
import app.repos.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MessageServices {

    @Autowired
    private final MessageRepo messageRepo;

    public Message create(Message message) {
        if (message.getText() == null || message.getText().length() < 1) {
            throw new UnsupportedOperationException("Incorrect message");
        }
        messageRepo.save(message);
        return message;
    }

    public void delete(int id) {
        messageRepo.deleteById(id);
    }

    public void update(Message message) {

    }

    public Optional<Message> read(Message message) {
        return messageRepo.findById(message.getId());
    }

    public List<Message> readAll() {
        return messageRepo.findAll();
    }
}

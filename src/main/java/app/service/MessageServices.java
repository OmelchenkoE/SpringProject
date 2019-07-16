package app.service;

import app.domain.Message;
import app.repos.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isEmpty(message.getText())) {
            throw new UnsupportedOperationException("Incorrect message");
        }
        messageRepo.save(message);
        return message;
    }

    public void delete(int id) {
        messageRepo.deleteById(id);
    }

    public Optional<Message> read(Message message) {
        return messageRepo.findById(message.getId());
    }

    public List<Message> readAll() {
        return messageRepo.findAll();
    }
}
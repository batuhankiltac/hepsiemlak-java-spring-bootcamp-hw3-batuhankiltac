package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.converter.MessageConverter;
import com.emlakburada.emlakburada.domain.Message;
import com.emlakburada.emlakburada.model.request.MessageRequest;
import com.emlakburada.emlakburada.queue.QueueService;
import com.emlakburada.emlakburada.repository.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private QueueService queueService;

    @Mock
    private MessageConverter messageConverter;

    @Test
    public void it_should_create_message() {
        // Given
        final MessageRequest messageRequest = MessageRequest.builder()
                .description("test-description")
                .build();

        // When
        messageService.createMessage(messageRequest);

        // Then
        assertThat(messageRequest.getDescription()).isEqualTo("test-description");
    }

    @Test
    public void it_should_get_all_messages() {
        // Given
        final Message message1 = Message.builder()
                .title("test-title1")
                .description("test-description1")
                .isSeen(true)
                .build();
        final Message message2 = Message.builder()
                .title("test-title2")
                .description("test-description2")
                .isSeen(false)
                .build();
        Set<Message> messages = Set.of(message1, message2);

        // When
        messageService.getAllMessages();

        // Then
        verify(messageRepository).findAllMessages();
        assertThat(message1.getDescription()).isNotNull();
        assertThat(messages.size()).isNotZero();
    }

    @Test
    public void it_should_get_by_id() {
        // Given
        final Integer id = 1;
        final Message message = Message.builder().build();
        when(messageRepository.findMessageById(id)).thenReturn(message);

        // When
        messageService.getMessageById(id);

        // Then
        verify(messageRepository).findMessageById(id);
    }
}

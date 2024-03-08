package dev.chipichapa.memestore.tgBot.noCommands.gallery;

import dev.chipichapa.memestore.domain.entity.Album;
import dev.chipichapa.memestore.tgBot.noCommands.NoCommand;
import dev.chipichapa.memestore.tgBot.states.UserChatStates;
import dev.chipichapa.memestore.tgBot.states.UserState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@AllArgsConstructor
public class CreateGalleryNameNC implements NoCommand {
    private UserChatStates userChatStates;
    @Override
    public UserState getNextState() {
        return UserState.CREATING_ALBUM_DESCRIPTION;
    }

    @Override
    public UserState getState() {
        return UserState.CREATING_ALBUM_NAME;
    }

    @Override
    public SendMessage handleMessage(Update update, SendMessage sm) {
        sm.setText("Введите название альбома:");
        return sm;
    }

    @Override
    public void handleState(Update update, Long tgId){

        Album album = userChatStates.getUserAlbum(tgId);
        album.setName(update.getMessage().getText());
        userChatStates.addUser(tgId, getNextState());
    }
}

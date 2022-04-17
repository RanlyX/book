package app.model.render;

import app.message.Message;

public class MessageRender implements ModelRender<app.model.view.Message, Message> {

    public app.model.view.Message render(Message message) {
        return new app.model.view.Message().setCode(message.getCode()).setDescription(message.getDescription())
                .setParameters(message.getParameters()).setParameterTypes(message.getParamsType());
    }

}

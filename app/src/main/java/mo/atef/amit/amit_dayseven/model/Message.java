package mo.atef.amit.amit_dayseven.model;

public class Message {
    CharSequence text;
    long time;
    CharSequence sender;

    public Message(CharSequence text, long time, CharSequence sender) {
        this.text = text;
        this.time = time;
        this.sender = sender;
    }

    public CharSequence getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public CharSequence getSender() {
        return sender;
    }

    public void setSender(CharSequence sender) {
        this.sender = sender;
    }
}

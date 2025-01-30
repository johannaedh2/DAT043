/*
        Solution to question 7 here.
 */

import java.util.ArrayList;
import java.util.List;

public class Q7 {

    public static void main(String[] args) {
        new Q7().program();
    }

    private void program() {
    }

    // TODO

    public class Message {
        private String avsändare;
        private String text;

        public Message(String avsändare,String text) {
            this.avsändare = avsändare;
            this.text = text;
        }

        public String getAvsändare() {
            return avsändare;
        }

        public String getText() {
            return text;
        }
    }

    public class Meddelandetråd {
        private final int id;
        private List<Message> messages = new ArrayList<>();

        public Meddelandetråd(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public List<Message> getMessages() {
            return messages;
        }

        void getMessage(Message m) {
            messages.add(m);
        }
    }

    public class Channel {
        private final int id;
        private List<Meddelandetråd> trådar = new ArrayList<>();

        public Channel (int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public List<Meddelandetråd> getTrådar() {
            return trådar;
        }

        Meddelandetråd check(Meddelandetråd m) {
            for (Meddelandetråd x : trådar) {
                if (x.id == m.id) {
                    return m;
                }
            }
            return null;
        }
    }

    public class Sluck {
        private List<String> användare = new ArrayList<>();
        private List<Channel> channels = new ArrayList<>();

        boolean publish(Message m,User u,Channel c,Meddelandetråd med) {
            if (c.trådar.contains(med)) {
                med.messages.add(m);
                c.trådar.add(med);
                return true;
            }
            return false;
        }
    }


    public class User {
        private String name;
        private String passwd;

        public User(String name, String passwd) {
            this.name = name;
            this.passwd = passwd;
        }
        // equals, hashCode, getter setter as needed
    }
}


import Theme from "./theme";
import User from "./user";

export default class Comment {
  id: number;
  content: string;
  theme: Theme;
  user: User;
}

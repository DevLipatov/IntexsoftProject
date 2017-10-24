import Theme from "./theme";
import User from "./user";

/**
 * Representation of comment entity
 */
export default class Comment {
  id: number;
  content: string;
  theme: Theme;
  user: User;
}

import Category from './category';
import User from "./user";

export default class Theme {
  id: number;
  title: string;
  content: string;
  category: Category;
  user: User;
  comments: Comment[];
}

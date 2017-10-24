import Category from './category';

/**
 * Representation of theme entity
 */
export default class Theme {
  id: number;
  title: string;
  content: string;
  category: Category;
  status: String;
}

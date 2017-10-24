import Theme from '../model/theme';

/**
 * Representation of category entity
 */
export default class Category {
  id: number;
  name: string;
  themes: Theme[];
}

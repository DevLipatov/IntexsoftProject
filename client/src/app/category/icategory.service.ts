import Category from "../model/category";

/**
 * Interface for category service
 */
interface ICategoryService {

  /**
   * Method to get all categories from database
   * @returns {Promise<Category[]>}
   */
  findAll(): Promise<Category[]>;

  /**
   * Method to put category to database
   * @returns {void}
   */
  add(category: Category): Promise<Category>;
}

export default ICategoryService;

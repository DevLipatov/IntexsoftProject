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
}

export default ICategoryService;

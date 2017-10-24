import Theme from "../model/theme";

/**
 * Interface for theme service
 */
interface IThemeService {
  /**
   * Method to get all themes from database
   * @returns {Promise<Theme[]>} - promise with list of themes
   */
  findAllThemes(): Promise<Theme[]>;

  /**
   * Method to get all themes with status "new" from database
   * @returns {Promise<Theme[]>} - promise with list of themes
   */
  findAllNewThemes(): Promise<Theme[]>;

  /**
   * Method to get all themes with status "deleted" from database
   * @returns {Promise<Theme[]>} - promise with list of themes
   */
  findAllDeletedThemes(): Promise<Theme[]>;

  /**
   * Method to get all themes from database by category name
   * @param {String} category - name of theme category
   * @returns {Promise<Theme[]>} - promise with list of themes
   */
  findPublishedByCategoryName(category: String): Promise<Theme[]>

  /**
   * Delete theme by it id
   * @param {number} id - id of the theme
   * @returns {Promise<Boolean>} status of delete
   */
  deleteById(id: number): Promise<Theme>
}

export default IThemeService;

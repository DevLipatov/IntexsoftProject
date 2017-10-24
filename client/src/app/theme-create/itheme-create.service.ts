import Theme from "../model/theme";

/**
 * Interface for theme service
 */
interface IThemeCreateService {
  /**
   * Method to save theme to database
   * @param {Theme} theme - theme to save to database
   * @returns {Promise<Theme>} - promise with saved theme
   */
  add(theme: Theme): Promise<Theme>;
}

export default IThemeCreateService;

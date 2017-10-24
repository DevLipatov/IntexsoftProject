import User from "../model/user";
import TokenObject from "../model/tokenobject";

/**
 * Interface for login service
 */
interface ILoginService {
  /**
   * Log user with username and password
   * @param {User} user - provides username and password
   * @returns {Promise<TokenObject>} - object, witch contains username, role and token
   */
  log(user: User): Promise<TokenObject>;

  /**
   * Log out user, refresh all localStorage parameters
   */
  logout(): void;
}

export default ILoginService;

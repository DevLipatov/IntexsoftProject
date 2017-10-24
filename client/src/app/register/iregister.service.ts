import User from "../model/user";
import {Observable} from "rxjs/Observable";

/**
 * Interface for register service
 */
interface IRegisterService {

  /**
   * Method to put user to database
   * @returns {void}
   */
  add(user: User): Promise<User>;
}

export default IRegisterService;

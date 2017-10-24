import User from "./user";

/**
 * Representation of token object, witch received from backend after successful login
 */
export default class TokenObject {
  username: string;
  role: string;
  token: string;
}

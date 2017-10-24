import Authority from "./authority";

/**
 * Representation of user entity
 */
export default class User {
  id: number;
  username: string;
  password: string;
  authorities: Authority[];
}

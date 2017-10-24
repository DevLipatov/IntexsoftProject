import User from "./user";

/**
 * Representation of authority entity
 */
export default class Authority {
  id: number;
  name: string;
  users: User[];
}

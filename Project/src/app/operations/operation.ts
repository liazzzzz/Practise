export interface Operation {
  id: number;
  type: string; // может enum должен быть?
  sum: number;
  note: string;
  createdAt: Date;
}

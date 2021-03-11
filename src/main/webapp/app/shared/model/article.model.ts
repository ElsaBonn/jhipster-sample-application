export interface IArticle {
  id?: number;
  designation?: string;
  stock?: number;
  nbPoints?: number;
  description?: string;
}

export class Article implements IArticle {
  constructor(
    public id?: number,
    public designation?: string,
    public stock?: number,
    public nbPoints?: number,
    public description?: string
  ) {}
}

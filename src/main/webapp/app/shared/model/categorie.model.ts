import { IArticle } from 'app/shared/model/article.model';

export interface ICategorie {
  id?: number;
  countryName?: string;
  categorie?: IArticle;
}

export class Categorie implements ICategorie {
  constructor(public id?: number, public countryName?: string, public categorie?: IArticle) {}
}

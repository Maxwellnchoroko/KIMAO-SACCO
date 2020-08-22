package models;
import org.sql2o.Sql2o;

public  class DB {
//           public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/kimao_sacco", "roselyne", "moraa@2018");
//public static Sql2o sql2o = new Sql2o("jdbc:postgresql:ec2-107-20-168-237.compute-1.amazonaws.com:5432/d8lbni28oi0bif", "ddcrxhkvttxlyu", "5f62c22456a84d626f99679583a4f1380ad85feafa91fe3fd40489cac551131a");

    public static     String connectionString = "jdbc:postgresql://ec2-107-20-168-237.compute-1.amazonaws.com:5432/d8lbni28oi0bif";
    public  static Sql2o sql2o = new  Sql2o(connectionString, "ddcrxhkvttxlyu", "5f62c22456a84d626f99679583a4f1380ad85feafa91fe3fd40489cac551131a");
}


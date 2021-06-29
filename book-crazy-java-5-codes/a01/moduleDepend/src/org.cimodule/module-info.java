
module org.cimodule
{
//	exports org.crazyit.user;
	exports org.crazyit.user to org.fkmodule;
//	opens org.crazyit.shop;
	opens org.crazyit.shop to org.fkmodule;
}

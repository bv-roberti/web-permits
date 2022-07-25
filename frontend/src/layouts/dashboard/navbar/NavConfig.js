// routes
import { PATH_DASHBOARD } from "../../../routes/paths";
// components
import Label from "../../../components/Label";
import Iconify from "../../../components/Iconify";
import SvgIconStyle from "../../../components/SvgIconStyle";

// ----------------------------------------------------------------------

const getIcon = (name) => (
  <SvgIconStyle
    src={`/assets/icons/navbar/${name}.svg`}
    sx={{ width: 1, height: 1 }}
  />
);

const ICONS = {
  blog: getIcon("ic_blog"),
  cart: getIcon("ic_cart"),
  chat: getIcon("ic_chat"),
  mail: getIcon("ic_mail"),
  user: getIcon("ic_user"),
  kanban: getIcon("ic_kanban"),
  banking: getIcon("ic_banking"),
  booking: getIcon("ic_booking"),
  invoice: getIcon("ic_invoice"),
  calendar: getIcon("ic_calendar"),
  ecommerce: getIcon("ic_ecommerce"),
  analytics: getIcon("ic_analytics"),
  dashboard: getIcon("ic_dashboard"),
  menuItem: getIcon("ic_menu_item"),
};

const navConfig = [
  // GENERAL
  // ----------------------------------------------------------------------
  {
    subheader: "Acesso rapido",
    items: [
      {
        title: "Inicio",
        path: PATH_DASHBOARD.general.app,
        icon: ICONS.dashboard,
      },
      {
        title: "Alvaras",
        path: PATH_DASHBOARD.alvaras.list,
        icon: ICONS.booking,
      },
      {
        title: "Relatorio Gerencial",
        path: "https://www.google.com/",
        icon: ICONS.menuItem,
      },
    ],
  },

  // MANAGEMENT
  // ----------------------------------------------------------------------
  {
    subheader: "Gerencimamento",
    items: [
      {
        title: "Alvaras",
        path: PATH_DASHBOARD.alvaras.root,
        icon: ICONS.booking,
        children: [
          { title: "list", path: PATH_DASHBOARD.alvaras.list },
          { title: "details", path: PATH_DASHBOARD.alvaras.demoView },
          { title: "create", path: PATH_DASHBOARD.alvaras.new },
          { title: "edit", path: PATH_DASHBOARD.alvaras.demoEdit },
        ],
      },
      {
        title: "Usuarios",
        path: PATH_DASHBOARD.user.root,
        icon: ICONS.user,
        children: [
          { title: "Listar", path: PATH_DASHBOARD.user.list },
          { title: "Adicionar", path: PATH_DASHBOARD.user.new },
          { title: "Editar", path: PATH_DASHBOARD.user.demoEdit },
        ],
      },
      {
        title: "Empresas",
        path: PATH_DASHBOARD.invoice.root,
        icon: ICONS.chat,
        children: [
          { title: "Listar", path: PATH_DASHBOARD.empresa.list },
          { title: "Adicionar", path: PATH_DASHBOARD.empresa.new },
          { title: "Editar", path: PATH_DASHBOARD.empresa.demoView },
        ],
      },

      {
        title: "Seguranca",
        path: PATH_DASHBOARD.blog.root,
        icon: ICONS.blog,
        children: [{ title: "Auditoria", path: PATH_DASHBOARD.security.audit }],
      },
      {
        title: "Relatorios",
        path: PATH_DASHBOARD.blog.root,
        icon: ICONS.menuItem,
        children: [
          { title: "R1 - Gerencial", path: "https://www.google.com/" },
          { title: "R2 - Executivo", path: "https://www.google.com/" },
        ],
      },
    ],
  },
];

export default navConfig;

package au.usyd.elec5619.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Comment;
import au.usyd.elec5619.service.CommentManager;

@Controller
@RequestMapping(value="/comment/**")
public class CommentController {
	@Resource(name="simpleCommentManager")
	private CommentManager scm;
	
	@RequestMapping(value="/")
	public ModelAndView showComment(HttpServletRequest request) {
		Map<String,Object> aModel=new HashMap<String, Object>();
		List<Comment> comments = this.scm.getAllComments();
		aModel.put("comments", comments);
		return new ModelAndView("commentlist", "model", aModel);
	}
	
	@RequestMapping(value="/commentpage")
	public ModelAndView page(HttpServletRequest request) {
		return new ModelAndView("commentpage");
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(HttpServletRequest request) {
		long   userId    = Long.parseLong(request.getParameter("userId"));
		long   productId = Long.parseLong(request.getParameter("productId"));
		int    score     = Integer.parseInt(request.getParameter("score"));
		String subject   = request.getParameter("subject");
		String content   = request.getParameter("content");
		Comment comment  = new Comment();
		comment.setId(new Date().getTime());
		comment.setTime(new Date());
		comment.setUserId(userId);
		comment.setProductId(productId);
		comment.setScore(score);
		comment.setSubject(subject);
		comment.setContent(content);
		
		this.scm.addComment(comment);
		
		return new ModelAndView("redirect:./");
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(HttpServletRequest request) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		scm.deleteComment(id);
		return new ModelAndView("redirect:./");
		
	}
	
	@RequestMapping(value="/getcommentsbyuser")
	public ModelAndView getCommentsByUser(HttpServletRequest request) throws Exception {
		Map<String,Object> aModel=new HashMap<String, Object>();
		List<Comment> comments = this.scm.getCommentsByUser(Long.parseLong(request.getParameter("userId")));
		aModel.put("comments", comments);
		return new ModelAndView("commentlist", "model", aModel);
	}
	
	@RequestMapping(value="/getcommentsbyproduct")
	public ModelAndView getCommentsByProduct(HttpServletRequest request) throws Exception {
		Map<String,Object> aModel=new HashMap<String, Object>();
		List<Comment> comments = this.scm.getCommentsByProduct(Long.parseLong(request.getParameter("productId")));
		aModel.put("comments", comments);
		return new ModelAndView("commentlist", "model", aModel);
	}
}
